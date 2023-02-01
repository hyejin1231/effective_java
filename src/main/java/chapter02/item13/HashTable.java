package chapter02.item13;

/**
 * item13. clone 재정의는 주의해서 진행하라.
 * 가변 객체 clone 정의하는 방법 - deep copy
 */
public class HashTable implements Cloneable {

    private Entry[] buckets = new Entry[10];

    private static class Entry {
        final Object key;
        Object value;
        Entry next;

        public Entry(Object key, Object value, Entry next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public void add(Object key, Object value) {
            this.next = new Entry(key, value, null);
        }

        // 재귀적인 방법은 StackOverflow를 발생시킬 수 있기 때문에..
//        public Entry deepCopy() {
//            return new Entry(key, value, next == null ? null : next.deepCopy());
//        }

        public Entry deepCopy() {
            Entry result = new Entry(key, value, next);
            for (Entry p = result; p.next != null; p = p.next) {
                p.next = new Entry(p.next.key, p.next.value, p.next.next);
            }

            return result;
        }

    }

//    @Override
//    public HashTable clone()  {
//        try {
//            HashTable result = (HashTable) super.clone();
//            result.buckets = this.buckets.clone(); // 얕은 copy여서 위험하다!!
//            return result;
//        } catch (CloneNotSupportedException e) {
//            throw new AssertionError();
//        }
//    }

    // deep copy clone
    @Override
    public HashTable clone() {
        HashTable result = null;
        try {
            result = (HashTable) super.clone();
            result.buckets = new Entry[this.buckets.length]; // clone 용 배열 새로 만들어줌

            for (int i = 0; i < this.buckets.length; i++) {
                if (buckets[i] != null) {
                    result.buckets[i] = this.buckets[i].deepCopy();
                }
            }
            return result;

        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    public static void main(String[] args) {
        HashTable hashTable = new HashTable();
        Entry entry = new Entry(new Object(), new Object(), null);
        hashTable.buckets[0] = entry;

        HashTable clone = hashTable.clone();
        System.out.println("(hashTable.buckets[0] == entry) = " + (hashTable.buckets[0] == entry));
        System.out.println("hashTable.buckets[0] == clone.buckets[0] = " + (hashTable.buckets[0] == clone.buckets[0]));
    }
}
