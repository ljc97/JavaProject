package 结构型模式.组合模式.模拟杀毒软件;

import java.util.ArrayList;
import java.util.List;

//抽象构建
public interface AbstractFile {
    //    杀毒
    void killVirus();
}

//以下为具体文件（叶子）
class ImgFile implements AbstractFile {
    @Override
    public void killVirus() {
        System.out.println("图片杀毒");
    }
}


class textFile implements AbstractFile {
    @Override
    public void killVirus() {
        System.out.println("文本杀毒");
    }
}


class videoFile implements AbstractFile {
    @Override
    public void killVirus() {
        System.out.println("音频杀毒");
    }
}

//以下为文件夹（容器）
class Floder implements AbstractFile {
    //    用来存放容器下的子节点
    private List<AbstractFile> list = new ArrayList<>();

    @Override
    public void killVirus() {
        System.out.println("---------文件夹开始杀毒----------");
        for (AbstractFile file : list) {
            file.killVirus();
        }
    }

    public void add(AbstractFile file) {
        list.add(file);
    }

    public void del(AbstractFile file) {
        list.remove(file);
    }

    public AbstractFile getChild(int index) {
        return list.get(index);
    }
}
