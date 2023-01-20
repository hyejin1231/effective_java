package chapter01.item07.cache;

import java.util.Comparator;
import java.util.Date;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PostRepositoryTest
{
	@Test
	void cache() throws InterruptedException
	{
		PostRepository postRepository = new PostRepository();
		Integer p1 = 1;
		postRepository.getPostById(p1);
		
		assertFalse(postRepository.getCache().isEmpty());
		
		System.out.println("run gc");
		System.gc();
		System.out.println("wait");
		Thread.sleep(3000L);
		
		assertTrue(postRepository.getCache().isEmpty());
	}
	
	// 백그라운드 서비스를 통해서
	@Test
	void backgroundThread() throws InterruptedException
	{
		ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
		PostRepository postRepository = new PostRepository();
		CacheKey key1 = new CacheKey(1);
		postRepository.getPostById(1);
		
		Runnable removeOldCache = () -> {
			System.out.println("running removeOldCache task");
			Map<CacheKey, Post> cache = postRepository.getCache();
			Set<CacheKey> cacheKeys = cache.keySet();
			Optional<CacheKey> key = cacheKeys.stream()
					.min(Comparator.comparing(CacheKey::getCreated));
			key.ifPresent((k)-> {
				System.out.println("removing " + k);
				cache.remove(k);
			});
		};
			
			System.out.println("The time is : " + new Date());
			
			executor.scheduleAtFixedRate(removeOldCache, 1, 3,
										 TimeUnit.SECONDS);
			
			Thread.sleep(20000L);
			
			executor.shutdown();
		
	}
}