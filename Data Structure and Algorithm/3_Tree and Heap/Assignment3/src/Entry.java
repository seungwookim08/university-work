public class Entry <K,V> {
	// Entry has 2 values (key and value).
	K key;
	V value;
	
	// Default constructor
	public Entry(K k, V v) {
		key = k;
		value = v;
	}
	
	// getters (no setters since value and key will not be changed)
	public K getKey() {
		return key;
	}
	public V getValue() {
		return value;
	}
	
	// Comparing keys depending on what is the type of key. 
	// In my test, I only used integer but I made it comparable with double and String as well.
	public int compareKey(Entry<K, V> ent2) {
		if (key.getClass().getSimpleName().equals("Integer")) {
			if ((int)key - (int) ent2.getKey()>=0)
				return 1;
			else 
				return -1;
		}
		else if (key.getClass().getSimpleName().equals("Double")){
			if ((double)key - (double) ent2.getKey()>=0)
				return 1;
			else 
				return -1;
		}
		else if (key.getClass().getSimpleName().equals("String"))
			if (((String) key).compareTo((String)ent2.getKey())>=0)
				return 1;
			else 
				return -1;
		return 0;
		
	}
	
	// toString method
	public String toString() {
		return "Key is " + key + " and value is " + value;
	}
}
