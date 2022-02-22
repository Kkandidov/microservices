package org.astashonok.library.utils;

import java.util.Collection;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CommonUtils {

  public static <T> boolean equalsIgnoreEmptyAndNull(Collection<T> collection1,
      Collection<T> collection2) {

    return (CollectionUtils.isEmpty(collection1) && CollectionUtils.isEmpty(collection2))
        || collection1.equals(collection2);
  }
}
