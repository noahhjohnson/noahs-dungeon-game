public class nearTrashcan {

    public static boolean isNearBottomRight(){
        if(Map.bbottomRight != null && Main.p.x == 15 && Main.p.y == 13
                || Main.p.x == 16 && Main.p.y == 14
                || Main.p.x == 15 && Main.p.y == 15
                || Main.p.x == 14 && Main.p.y == 14) return true;
        return false;
    }

    public static boolean isNearTopRight(){
        if(Map.btopRight != null && Main.p.x == 14 && Main.p.y == 2
                || Main.p.x == 15 && Main.p.y == 3
                || Main.p.x == 14 && Main.p.y == 4
                || Main.p.x == 13 && Main.p.y == 3) return true;
        return false;
    }

    public static boolean isNearTopLeft(){
        if(Map.btopLeft != null && Main.p.x == 6 && Main.p.y == 3
                || Main.p.x == 5 && Main.p.y == 2
                || Main.p.x == 4 && Main.p.y == 3
                || Main.p.x == 5 && Main.p.y == 4) return true;
        return false;
    }
}
