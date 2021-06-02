package helper;

import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;

public class Helper {

    public static String getString(ButtonGroup group) {
        Enumeration<AbstractButton> buttons = group.getElements();
        while (buttons.hasMoreElements()) {
            AbstractButton button = buttons.nextElement();
            if (button.isSelected())
                return button.getActionCommand();
        }
        return null;
    }

    public static int getInt(ButtonGroup group) {
        return Integer.parseInt(getString(group));
    }

    public static char getChar(ButtonGroup group) {
        return getString(group).charAt(0);
    }

}
