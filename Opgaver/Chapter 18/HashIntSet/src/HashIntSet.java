/**
 * Created by David Stovlbaek on 06/10/16.
 */
public class HashIntSet {

    private static final double MAX_LOAD_FACTOR = 0.75;
    private HashEntry[] elementData;
    private int size;

    public HashIntSet() {
        this.elementData = new HashEntry[10];
    }

    // Adds the given element to this set, if it was not
    // already contained in the set.
    public void add(int value) {
        if (loadFactor() >= MAX_LOAD_FACTOR) {
            rehash();
        }
        if (!contains(value)) {
            // insert new value at front of list
            int bucket = hashCode(value);
            elementData[bucket] = new HashEntry(value, elementData[bucket]);
            size++;
        }
    }

    // Returns true if the given value is found in this set.
    public boolean contains(int value) {
        int bucket = hashCode(value);
        HashEntry current = elementData[bucket];
        while (current != null) {
            if (current.data == value) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // Removes the given value if it is contained in the set.
    public void remove(int value) {
        int bucket = hashCode(value);
        if (elementData[bucket] != null) {
            // check front of list
            if (elementData[bucket].data == value) {
                elementData[bucket] = elementData[bucket].next;
                size--;
            } else {
                // check rest of list
                HashEntry current = elementData[bucket];
                while (current.next != null && current.next.data != value) {
                    current = current.next;
                }
                // if the element is found, remove it
                if (current.next != null) {
                    current.next = current.next.next;
                    size--; }
            }
        }
    }

    private int hashCode(int value) {
        return Math.abs(value) % elementData.length;
    }

    private void rehash() {
        // replace element data array with a larger empty version
        HashEntry[] oldElementData = elementData;
        elementData = new HashEntry[2 * oldElementData.length];
        size = 0;
        // re-add all of the old data into the new array
        for (int i = 0; i < oldElementData.length; i++) {
            HashEntry current = oldElementData[i];
            while (current != null) {
                add(current.data);
                current = current.next;
            }
        }
    }

    private double loadFactor() {
        return (double) size / elementData.length;
    }

    private class HashEntry {
        private int data;
        private HashEntry next;

        public HashEntry(int data) {
            this(data, null);
        }

        public HashEntry(int data, HashEntry next) {
            this.data = data;
            this.next = next;
        }
    }

    /**
     * My methods
     */

    public HashEntry[] getElementData() {
        return elementData;
    }

    public int getSize() {
        return size;
    }

    public void addAll(HashIntSet set){
        HashEntry[] oldArr = set.getElementData();

        for(int i = 0; i < oldArr.length; i++){
            if(oldArr[i] != null){
                HashEntry current = oldArr[i];
                add(current.data);
                while(current.next != null){
                    current = oldArr[i].next;
                    add(current.data);
                }
            }
        }

    }

    public boolean containsAll(HashIntSet set){
        if(set.getSize() > size) return false;

        int counter = 0;

        for (HashEntry anElementData : elementData) {
            HashEntry current = anElementData;
            if (current != null) {
                    if(set.contains(current.data)) counter++;

                while (current.next != null) {
                    current = current.next;
                    if(set.contains(current.data)) counter++;
                }
            }
        }
        return counter == set.getSize();
    }

    public boolean equals(HashIntSet set){
        if(set.getSize() != size) return false;

        for (HashEntry anElementData : elementData) {
            HashEntry current = anElementData;
            if (current != null) {
                if(!set.contains(current.data)) return false;

                while (current.next != null) {
                    current = current.next;
                    if(!set.contains(current.data)) return false;
                }
            }
        }
        return true;
    }

    public void removeAll(HashIntSet set){
        for (HashEntry anElementData : elementData) {
            if (anElementData != null) {
                if(set.contains(anElementData.data))
                   remove(anElementData.data);
            }
        }
    }

    public void retainAll(HashIntSet set){
        for (HashEntry anElementData : elementData) {
            if (anElementData != null) {
                if(!set.contains(anElementData.data))
                    remove(anElementData.data);
            }
        }
    }

    public int[] toArray(){

        int[] rArr = new int[size];
        int counter = 0;

        for (HashEntry anElementData : elementData) {
            HashEntry current = anElementData;
            if (current != null) {
                rArr[counter] = current.data;
                counter++;
                while (current.next != null) {
                    current = current.next;
                    rArr[counter] = current.data;
                    counter++;
                }
            }
        }
        return rArr;
    }

    @Override
    public String toString() {
        String rString = "[";
        boolean check = true;

        for (HashEntry anElementData : elementData) {
            HashEntry current = anElementData;
            if (current != null) {
                if (check) {
                    rString += current.data;
                    check = false;
                } else
                    rString += ", " + current.data;

                while (current.next != null) {
                    current = current.next;
                    rString += ", " + current.data;
                }
            }
        }
        return rString + "]";
    }
}
