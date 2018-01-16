package mission03.model;

/**
 * Created by newt.on on 2018. 1. 15..
 */
//Comparable<Menu>가 어디있는건지 모르겠어요ㅠㅠ
public abstract class Menu implements Comparable<Menu> {
    private String key;

    private String text;

    public Menu(String key, String text) {
        this.key = key;
        this.text = text;
    }

    public String getText() {
        return this.text;
    }

    protected abstract void onSelected();

    public void select() {
        System.out.println(text + " 메뉴를 선택하셨습니다.");
        onSelected();
    }

    @Override
    //compareTo(Menu o)의 위치를 모르겠어요 
    public int compareTo(Menu o) {
        return key.compareTo(o.key);
    }
}
