package by.bsuir.ptoop.model;

import java.io.Serializable;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

/**
 * Proxy class for {@link Figure} ArrayList
 */
public class FigureList implements List<Figure>, Serializable {

    private static final long serialVersionUID = 3904027062008261626L;

    private List<Figure> list;

    public FigureList() {
        list = new ArrayList<>();
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return list.contains(o);
    }

    @Override
    public Iterator<Figure> iterator() {
        return list.iterator();
    }

    @Override
    public Object[] toArray() {
        return list.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return list.toArray(a);
    }

    @Override
    public boolean add(Figure figure) {
        return list.add(figure);
    }

    @Override
    public boolean remove(Object o) {
        return list.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return list.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends Figure> c) {
        return list.addAll(c);
    }

    @Override
    public boolean addAll(int index, Collection<? extends Figure> c) {
        return list.addAll(index, c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return list.removeAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return list.retainAll(c);
    }

    @Override
    public void replaceAll(UnaryOperator<Figure> operator) {
        list.replaceAll(operator);
    }

    @Override
    public void sort(Comparator<? super Figure> c) {
        list.sort(c);
    }

    @Override
    public void clear() {
        list.clear();
    }

    @Override
    public boolean equals(Object o) {
        return list.equals(o);
    }

    @Override
    public int hashCode() {
        return list.hashCode();
    }

    @Override
    public Figure get(int index) {
        return list.get(index);
    }

    @Override
    public Figure set(int index, Figure element) {
        return list.set(index, element);
    }

    @Override
    public void add(int index, Figure element) {
        list.add(index, element);
    }

    @Override
    public Figure remove(int index) {
        return list.remove(index);
    }

    @Override
    public int indexOf(Object o) {
        return list.indexOf(o);
    }

    @Override
    public int lastIndexOf(Object o) {
        return list.lastIndexOf(o);
    }

    @Override
    public ListIterator<Figure> listIterator() {
        return list.listIterator();
    }

    @Override
    public ListIterator<Figure> listIterator(int index) {
        return list.listIterator(index);
    }

    @Override
    public List<Figure> subList(int fromIndex, int toIndex) {
        return list.subList(fromIndex, toIndex);
    }

    @Override
    public Spliterator<Figure> spliterator() {
        return list.spliterator();
    }

    @Override
    public boolean removeIf(Predicate<? super Figure> filter) {
        return list.removeIf(filter);
    }

    @Override
    public Stream<Figure> stream() {
        return list.stream();
    }

    @Override
    public Stream<Figure> parallelStream() {
        return list.parallelStream();
    }

    @Override
    public void forEach(Consumer<? super Figure> action) {
        list.forEach(action);
    }
}
