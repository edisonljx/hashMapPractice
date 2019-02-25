public class HashMap<K,V> implements Map<K,V> {


    private static int defaultLength = 16;
    private static double defaultLoader = 0.75;
    private Entry[] table = null;
    private int size = 0;


    public HashMap(){
        this(defaultLength, defaultLoader);
    }


    public HashMap(int length, double loader){
        defaultLength = length;
        defaultLoader = loader;
        table = new Entry[defaultLength];
    }




    @Override
    public V put(K k, V v) {
        size++;

        int index = hash(k);
        Entry<K,V> entry = table[index];
        if (entry == null){
            table[index] = newEntry(k , v, null);

        }else {
            table[index] = newEntry(k,v,entry);
            //System.out.println("The old value: " + table[index].next.getValue());
        }


        return (V) table[index].getValue();
    }

    public Entry<K,V> newEntry(K k, V v, Entry<K,V> next){
        return new Entry<K,V>(k,v,next);
    }

    public int hash(K k){
        int m = defaultLength;
        int i = k.hashCode()%m;
        return i >=0 ? i : -i;
    }

    @Override
    public V get(K k) {
        int index = hash(k);
        if(table[index] == null){
            return null;
        }
        return (V)findValue(k, table[index]);
    }

    public V findValue(K k, Entry<K,V> entry){
        if (k == entry.getKey() || k.equals(entry.getKey())){
            return entry.getValue();
        } else {
            if (entry.next!= null){
                return findValue(k, entry.next);
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    class Entry<K,V> implements Map.Entry<K,V>{

        K k;
        V v;

        Entry<K,V> next;

        public Entry(K k, V v, Entry<K,V> next){
            this.k = k;
            this.v = v;
            this.next = next;
        }

        @Override
        public K getKey() {
            return k;
        }

        @Override
        public V getValue() {
            return v;
        }
    }

}
