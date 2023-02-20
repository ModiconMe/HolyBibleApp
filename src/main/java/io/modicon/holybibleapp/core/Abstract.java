package io.modicon.holybibleapp.core;

public abstract class Abstract {

    public static abstract class Object<T, M extends Mapper> {

        public abstract T map(M mapper);
    }

    public interface Mapper {

        class Empty implements Mapper { }
    }
}
