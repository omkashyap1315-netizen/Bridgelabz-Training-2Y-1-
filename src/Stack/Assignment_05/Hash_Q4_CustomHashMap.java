package Stack.Assignment_05;

import java.util.Objects;

public class Hash_Q4_CustomHashMap {

    static class MyHashMap<K, V> {

        private static class Node<K, V> {
            final K key;
            V value;
            Node<K, V> next;

            Node(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        private Node<K, V>[] buckets;
        private int size = 0;
        private static final double LOAD_FACTOR = 0.75;

        @SuppressWarnings("unchecked")
        MyHashMap() {
            buckets = (Node<K, V>[]) new Node[16];
        }

        private int indexFor(K key, int length) {
            int hash = (key == null) ? 0 : (key.hashCode() & 0x7fffffff);
            return hash % length;
        }

        // Insert or update
        void put(K key, V value) {
            int idx = indexFor(key, buckets.length);
            for (Node<K, V> n = buckets[idx]; n != null; n = n.next) {
                if (Objects.equals(n.key, key)) {
                    n.value = value; // key exists -> update
                    return;
                }
            }
            Node<K, V> node = new Node<>(key, value);
            node.next = buckets[idx]; // add at head of the chain
            buckets[idx] = node;
            size++;
            if (size > buckets.length * LOAD_FACTOR) resize();
        }

        // Retrieve (null if not found)
        V get(K key) {
            int idx = indexFor(key, buckets.length);
            for (Node<K, V> n = buckets[idx]; n != null; n = n.next) {
                if (Objects.equals(n.key, key)) return n.value;
            }
            return null;
        }

        // Delete
        boolean remove(K key) {
            int idx = indexFor(key, buckets.length);
            Node<K, V> prev = null, curr = buckets[idx];
            while (curr != null) {
                if (Objects.equals(curr.key, key)) {
                    if (prev == null) buckets[idx] = curr.next;
                    else prev.next = curr.next;
                    size--;
                    return true;
                }
                prev = curr;
                curr = curr.next;
            }
            return false;
        }

        boolean containsKey(K key) {
            return get(key) != null;
        }

        int size() {
            return size;
        }

        @SuppressWarnings("unchecked")
        private void resize() {
            Node<K, V>[] old = buckets;
            buckets = (Node<K, V>[]) new Node[old.length * 2];
            for (Node<K, V> head : old) {
                for (Node<K, V> n = head; n != null; n = n.next) {
                    int idx = indexFor(n.key, buckets.length);
                    Node<K, V> copy = new Node<>(n.key, n.value);
                    copy.next = buckets[idx];
                    buckets[idx] = copy;
                }
            }
        }
    }

    public static void main(String[] args) {
        MyHashMap<String, Integer> map = new MyHashMap<>();
        map.put("apple", 10);
        map.put("banana", 20);
        map.put("cherry", 30);
        map.put("apple", 15); // update existing key

        System.out.println("apple  = " + map.get("apple"));   // 15
        System.out.println("banana = " + map.get("banana"));  // 20
        System.out.println("grape  = " + map.get("grape"));   // null
        System.out.println("Remove banana: " + map.remove("banana")); // true
        System.out.println("Contains banana? " + map.containsKey("banana")); // false
        System.out.println("Size = " + map.size()); // 2

        // add many keys to trigger resize
        for (int i = 0; i < 50; i++) map.put("key" + i, i);
        System.out.println("After adding 50 keys -> size = " + map.size() + ", key25 = " + map.get("key25"));
    }
}

