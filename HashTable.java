import java.util.LinkedList;

public class HashTable<K, V> {
    @SuppressWarnings("hiding")
		private class HashNode<K, V> {
        K key;
        V value;

        public HashNode(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private LinkedList<HashNode<K, V>>[] chainArray;
    private int numBuckets;
    private int size;

    // Конструктор по умолчанию
    @SuppressWarnings("unchecked")
		public HashTable() {
        chainArray = new LinkedList[10];  // Массив цепочек
        numBuckets = 10;                  // Количество корзин (buckets)
        size = 0;

        // Инициализация каждой корзины пустым списком
        for (int i = 0; i < numBuckets; i++) {
            chainArray[i] = new LinkedList<>();
        }
    }

    // Метод для вычисления хэш-значения
    private int hashCode(K key) {
        return Math.abs(key.hashCode() % numBuckets);
    }

    // Метод добавления ключа и значения
    public void put(K key, V value) {
        int bucketIndex = hashCode(key);
        LinkedList<HashNode<K, V>> chain = chainArray[bucketIndex];

        // Проверка, существует ли уже ключ
        for (HashNode<K, V> node : chain) {
            if (node.key.equals(key)) {
                node.value = value;  // Обновляем значение
                return;
            }
        }

        // Добавление новой пары
        HashNode<K, V> newNode = new HashNode<>(key, value);
        chain.add(newNode);
        size++;
    }

    // Метод для получения значения по ключу
    public V get(K key) {
        int bucketIndex = hashCode(key);
        LinkedList<HashNode<K, V>> chain = chainArray[bucketIndex];

        // Поиск ключа в цепочке
        for (HashNode<K, V> node : chain) {
            if (node.key.equals(key)) {
                return node.value;
            }
        }

        // Ключ не найден
        return null;
    }

    // Метод удаления ключа
    public V remove(K key) {
        int bucketIndex = hashCode(key);
        LinkedList<HashNode<K, V>> chain = chainArray[bucketIndex];

        // Поиск и удаление ключа
        for (HashNode<K, V> node : chain) {
            if (node.key.equals(key)) {
                chain.remove(node);
                size--;
                return node.value;
            }
        }

        // Ключ не найден
        return null;
    }

    // Метод для получения размера таблицы
    public int size() {
        return size;
    }

    // Метод для проверки, пуста ли таблица
    public boolean isEmpty() {
        return size == 0;
    }
}
