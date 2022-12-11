package by.itstep.clothesshop.model;

public enum SizeProd {
    XS(40), S(42), M(44), L(46), XL(48), XXL(50);
    private final Integer size;

    SizeProd(Integer code) {
        this.size = code;
    }

    public Integer code() {
        return size;
    }
}
