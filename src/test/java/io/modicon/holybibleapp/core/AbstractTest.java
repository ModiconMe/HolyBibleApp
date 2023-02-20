package io.modicon.holybibleapp.core;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AbstractTest {

    @Test
    void test_success() {
        var dataObject = new TestDataObject.Success("a", "b");
        var domainObject = dataObject.map(new DataToDomainMapper.Base());

        assertEquals(TestDomainObject.Success.class, domainObject.getClass());
    }

    @Test
    void test_fail() {
        var dataObject = new TestDataObject.Fail(new RuntimeException());
        var domainObject = dataObject.map(new DataToDomainMapper.Base());

        assertEquals(TestDomainObject.Fail.class, domainObject.getClass());
    }
}

abstract class TestDataObject extends Abstract.Object<TestDomainObject, DataToDomainMapper> {
    @Override
    public abstract TestDomainObject map(DataToDomainMapper mapper);

    @RequiredArgsConstructor
    static class Success extends TestDataObject {

        private final String text1;
        private final String text2;

        @Override
        public TestDomainObject map(DataToDomainMapper mapper) {
            return mapper.map(text1, text2);
        }
    }

    @RequiredArgsConstructor
    static class Fail extends TestDataObject {

        private final Exception exception;

        @Override
        public TestDomainObject map(DataToDomainMapper mapper) {
            return mapper.map(exception);
        }
    }
}

abstract class TestDomainObject extends Abstract.Object<TestDtoObject, DomainToDtoMapper> {
    @Override
    public abstract TestDtoObject map(DomainToDtoMapper mapper);

    @Getter
    @RequiredArgsConstructor
    static class Success extends TestDomainObject {

        private final String textCombined;

        @Override
        public TestDtoObject map(DomainToDtoMapper mapper) {
            return null;
        }
    }

    static class Fail extends TestDomainObject {

        @Override
        public TestDtoObject map(DomainToDtoMapper mapper) {
            return null;
        }
    }
}

interface DataToDomainMapper extends Abstract.Mapper {
    TestDomainObject map(String text1, String text2);
    TestDomainObject map(Exception exception);

    class Base implements DataToDomainMapper {
        @Override
        public TestDomainObject map(String text1, String text2) {
            return new TestDomainObject.Success(text1 + text2);
        }

        @Override
        public TestDomainObject map(Exception exception) {
            return new TestDomainObject.Fail();
        }
    }
}

interface DomainToDtoMapper extends Abstract.Mapper {
    // todo
}

abstract class TestDtoObject extends Abstract.Object<Void, Abstract.Mapper.Empty> {
}