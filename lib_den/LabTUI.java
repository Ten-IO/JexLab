package lib_den;

public class LabTUI {

    /**
     * Menu Decore are signs in between the Title<br>
     * 
     * @Example
     *          = Title =
     * @note
     *       Default value: "="
     */
    static String menu_decore = "=";

    // List Decore are style between list's Number and list's Detail
    // Ex: 1. List01 (list_decore : String = ". ")
    // 2::List01 (list_decore : String = "::")
    static String list_decore = ". ";

    /**
     * @menu_sign_reptition Amount of sign to repeat `if (menu_sign_repetition : int
     *                      = 2)`
     * @Example == Title ==
     * @list_start_from Number to start from `if (list_start_from : int = 3)`
     * @Example
     *          3. List01
     *          <li>
     *          4. List02
     *          </li>
     */
    static int menu_sign_repetition = 3, list_start_from = 1;

    /* SETTER + GETTER */
    public static String getmenu_decore() {
        return menu_decore;
    }

    public static void setmenu_decore(String menu_decore) {
        LabTUI.menu_decore = menu_decore;
    }

    public static String getlist_decore() {
        return list_decore;
    }

    public static void setlist_decore(String list_decore) {
        LabTUI.list_decore = list_decore;
    }

    public static int getMenu_sign_repetition() {
        return menu_sign_repetition;
    }

    public static void setMenu_sign_repetition(int menu_sign_repetition) {
        LabTUI.menu_sign_repetition = menu_sign_repetition;
    }

    public static int getList_start_from() {
        return list_start_from;
    }

    public static void setList_start_from(int list_start_from) {
        LabTUI.list_start_from = list_start_from;
    }

    /* FUNCTION */

    /**
     * @
     * @param   title main content t be displayed as menu header
     * @param list detailed choice
     * 
     */
    static public void create(String title, String[] list) {
        System.out.println(
                menu_decore.repeat(menu_sign_repetition) + ' ' + title + ' '
                        + menu_decore.repeat(menu_sign_repetition));

        int listSize = list.length, n = list_start_from;

        // Print item from list
        if (listSize > 0)
            for (String l : list)
                System.out.println((n++) + list_decore + l);
    }

    static public void create(String title, String[] field, String[] list) {
        System.out.println(
                menu_decore.repeat(menu_sign_repetition) + ' ' + title + ' '
                        + menu_decore.repeat(menu_sign_repetition));

        if (field != null)
            for (String l : field)
                System.out.println(l);

        int listSize = list.length, n = list_start_from;

        // Print item from list
        if (listSize > 0)
            for (String l : list)
                System.out.println((n++) + list_decore + l);
    }

    static public void create(String title, Runnable[] field, String[] list) {
        System.out.println(
                menu_decore.repeat(menu_sign_repetition) + ' ' + title + ' '
                        + menu_decore.repeat(menu_sign_repetition));

        if (field != null)
            for (Runnable p : field)
                p.run();
        int listSize = list.length, n = list_start_from;

        // Print item from list
        if (listSize > 0)
            for (String l : list)
                System.out.println((n++) + list_decore + l);
    }
}