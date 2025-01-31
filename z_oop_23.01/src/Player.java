public class Player {
    String name;
    int health;
    Weapon weapon;

    public Player(String name, int health, Weapon weapon) {
        this.name = name;
        this.health = health;
        this.weapon = weapon;
    }

    public void attack(Enemy enemy) {
        System.out.println(name + " атакует " + enemy.name + " с " + weapon.name);
        enemy.health -= weapon.damage;
        System.out.println(enemy.name + " состояние здоровья(HP): " + enemy.health);
    }
}