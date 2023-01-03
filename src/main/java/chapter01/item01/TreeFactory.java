package chapter01.item01;

import java.util.HashMap;

// 공유한 Tree를 제공해줄 TreeFactory
public class TreeFactory
{
	// HashMap 자료구조를 통해 만들어진 Tree를 관리함
	public static final HashMap<String, Tree> treeMap = new HashMap<>();
	
	public static Tree getTree(String treeColor)
	{
		Tree tree = treeMap.get(treeColor); // 입력받은 색상의 tree가 있다면 반환
		
		if (tree == null) { // 없다면 새로운 tree 생성
			tree = new Tree(treeColor);
			treeMap.put(treeColor, tree);
			System.out.println("New Tree 생성!");
		}
		
		return tree;
	}
	
}
