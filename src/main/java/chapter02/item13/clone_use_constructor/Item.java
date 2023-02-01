package chapter02.item13.clone_use_constructor;

/**
 * item13. clone 재정의는 주의해서 진행하라.
 */
public class Item implements Cloneable {

    private String name;

    // 이렇게 구현하면 하위 클래스의 clone()이 깨질 수 있다.
    // 생성자를 호출해서 만들면 안된다!!!!
//    @Override
//    public Item clone() {
//        Item item = new Item();
//        item.name = this.name;
//        return item;
//    }

    // 제대로 구현한 clone
    @Override
    public Item clone()  {
        Item result = null;
        try {
            result = (Item) super.clone();
            return result;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
