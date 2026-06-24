class Fighter {

    boolean isVulnerable() {
        return true;
    }

    int getDamagePoints(Fighter fighter) {
        return 1;
    }
}

class Warrior extends Fighter {
    public Warrior() {
    }

    @Override
    public String toString() { return "Fighter is a Warrior"; }
    @Override
    public boolean isVulnerable() { return false; }

    @Override
    public int getDamagePoints(Fighter fighter) {
        if (fighter.isVulnerable()) {
            return 10;
        } else {
            return 6;
        }
    }
}

class Wizard extends Fighter {
    private boolean spellPrepared = false;

    public Wizard() {
    }

    public void prepareSpell() {
        this.spellPrepared = true;
    }

    @Override
    public String toString() { return "Fighter is a Wizard"; }

    @Override
    public boolean isVulnerable() {
        return !spellPrepared;
    }

    @Override
    public int getDamagePoints(Fighter fighter) {
        if (spellPrepared) {
            return 12;
        } else {
            return 3;
        }
    }
}

class VulnerableFighter extends Fighter {
}

class InvulnerableFighter extends Fighter {
    @Override
    boolean isVulnerable() {
        return false;
    }
}
