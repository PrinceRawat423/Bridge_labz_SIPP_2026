public class AdventureGameDemo {
    public static void main(String[] args) {
        GameCharacter[] characters = {
            new Warrior("Arjun"),
            new Mage("Mina"),
            new Archer("Rohan")
        };

        startBattle(characters);
    }

    static void startBattle(GameCharacter[] characters) {
        int warriors = 0, mages = 0, archers = 0;
        for (GameCharacter character : characters) {
            character.performAttack();
            if (character instanceof Warrior) warriors++;
            else if (character instanceof Mage) mages++;
            else if (character instanceof Archer) archers++;
        }
        System.out.println("Warriors: " + warriors);
        System.out.println("Mages: " + mages);
        System.out.println("Archers: " + archers);
    }

    static class GameCharacter {
        String characterName;

        GameCharacter(String characterName) {
            this.characterName = characterName;
        }

        void performAttack() {
            System.out.println(characterName + " attacks generically.");
        }
    }

    static class Warrior extends GameCharacter {
        Warrior(String characterName) {
            super(characterName);
        }

        @Override
        void performAttack() {
            System.out.println(characterName + " swings a sword.");
        }
    }

    static class Mage extends GameCharacter {
        Mage(String characterName) {
            super(characterName);
        }

        @Override
        void performAttack() {
            System.out.println(characterName + " casts a spell.");
        }
    }

    static class Archer extends GameCharacter {
        Archer(String characterName) {
            super(characterName);
        }

        @Override
        void performAttack() {
            System.out.println(characterName + " fires an arrow.");
        }
    }
}
