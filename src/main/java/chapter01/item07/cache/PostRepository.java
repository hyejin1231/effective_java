package chapter01.item07.cache;

import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

import org.springframework.cglib.core.WeakCacheKey;

/**
 * item07. 다 쓴 객체 참조를 해제하라.
 */
public class PostRepository
{
	private Map<CacheKey, Post> cache;
	
	public PostRepository()
	{
		this.cache = new HashMap<>();
//		this.cache = new WeakHashMap<>();
	}
	
	public Post getPostById(Integer id)
	{
		CacheKey key = new CacheKey(id);
		
		if (cache.containsKey(key)) {
			return cache.get(key);
		}else {
			Post post = new Post(); // TODO DB에서 읽어오거나 REST API를 통해 읽어올 수 있다.
			cache.put(key, post);
			return post;
		}
	}
	
	public Map<CacheKey, Post> getCache()
	{
		return cache;
	}
}
