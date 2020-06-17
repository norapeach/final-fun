

/**
 * Interface to be implemented by LinkedIntList or ArrayIntList
 * @author http://www.buildingjavaprograms.com/code-files/5ed/ch16/IntList.java
 * @see http://www.buildingjavaprograms.com/code-files/5ed/ch16/
 */
public interface IntList {
    public int size();
    public int get(int index);
    public String toString();
    public int indexOf(int value);
    public void add(int value);
    public void add(int index, int value);
    public void remove(int index);
}
