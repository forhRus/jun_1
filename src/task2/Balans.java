package task2;

public class Balans {

    private boolean proteins;
    private boolean fats;
    private boolean carbohydrares;

    public Balans() {
        proteins = false;
        fats = false;
        carbohydrares = false;
    }

    public boolean isProteins() {
        return proteins;
    }

    public boolean isFats() {
        return fats;
    }

    public boolean isCarbohydrares() {
        return carbohydrares;
    }

    public boolean isBalansed() {
        return proteins && fats && carbohydrares;
    }



    public void setProteins(boolean proteins) {
        this.proteins = proteins;
    }

    public void setFats(boolean fats) {
        this.fats = fats;
    }

    public void setCarbohydrares(boolean carbohydrares) {
        this.carbohydrares = carbohydrares;
    }
}
