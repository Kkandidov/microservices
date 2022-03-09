package org.astashonok.library.mappers;

import java.util.List;

public interface Mapper<T, R> {

  R map(T object);

  List<R> map(List<T> objects);
}
