package week06;

import java.awt.Font;

import javax.swing.UIManager;

public class setUIFont {
    public setUIFont(){
        setGlobalFont(new Font("Poppin", Font.PLAIN, 14));
    }
    public static void setGlobalFont(Font font) {
        for (Object key : UIManager.getDefaults().keySet())
            if (UIManager.get(key) instanceof Font)
                UIManager.put(key, font);
    }
}
