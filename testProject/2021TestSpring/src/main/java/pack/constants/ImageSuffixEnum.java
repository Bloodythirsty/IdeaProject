package pack.constants;

/**
 * @description:
 * @author: zhaobofan
 * @create: 2020/7/6 20:04
 **/
public enum ImageSuffixEnum {
    JPG(1, ".jpg"), JPEG(2, ".jpeg"), PNG(3, ".png"),GIF(4,".gif");

    int order;
    String suffix;

    ImageSuffixEnum(int order, String suffix) {
        this.order = order;
        this.suffix = suffix;
    }

    public int getOrder() {
        return order;
    }

    public String getSuffix() {
        return suffix;
    }

    public static ImageSuffixEnum parse(String suffix) {
        if (suffix == null) {
            return null;
        }
        for (ImageSuffixEnum imageSuffixEnum : ImageSuffixEnum.values()) {
            if (imageSuffixEnum.getSuffix().equals(suffix) || suffix.endsWith(imageSuffixEnum.getSuffix())) {
                return imageSuffixEnum;
            }
        }
        return null;
    }
}
