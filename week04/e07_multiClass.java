package week04;

interface Point {
    void setPoint(int x, int y);
}

class Line implements Point {
    int x1, y1, x2, y2;
    public void setPoint(int x, int y) {
        x1 = x; y1 = y;
    }
    void setSecondPoint(int x, int y) {
        x2 = x; y2 = y;
    }
}

class Triangle implements Point {
    int x1, y1, x2, y2, x3, y3;
    public void setPoint(int x, int y) {
        x1 = x; y1 = y;
    }
    void setSecondPoint(int x, int y) {
        x2 = x; y2 = y;
    }
    void setThirdPoint(int x, int y) {
        x3 = x; y3 = y;
    }
}

class Rectangle implements Point {
    int x, y, width, height;
    public void setPoint(int x, int y) {
        this.x = x; this.y = y;
    }
    void setDimensions(int w, int h) {
        width = w; height = h;
    }
}

class ITStudent {
    String name, id;
}

class ProgrammingStudent extends ITStudent {
    String programmingLanguage;
}

class TelecomStudent extends ITStudent {
    String networkType;
}