package chapter02.item13.clone_use_constructor;

/**
 * item13. clone 재정의는 주의해서 진행하라.
 */
public class SubItem extends Item implements Cloneable{

    private String name;

    @Override
    public SubItem clone() {
        return (SubItem) super.clone(); // Item -> SubItem으로 변환을 못하기 때문에 에러 발생함..!!
    }

    public static void main(String[] args) {
        SubItem subItem = new SubItem();
        SubItem clone = subItem.clone();

        System.out.println("(clone != null) = " + (clone != null));
        System.out.println("(clone.getClass() == subItem.getClass()) = " + (clone.getClass() == subItem.getClass()));
        System.out.println("clone.equals(subItem) = " + clone.equals(subItem));
    }
}
