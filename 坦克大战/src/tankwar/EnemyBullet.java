package tankwar;

import java.awt.*;
import java.util.List;

public class EnemyBullet extends Bullet {
    public EnemyBullet(String img, int x, int y, Direction direction,GamePanel gamePanel){
        super(img, x, y, direction, gamePanel);
    }

    public void hitTank(){
        Rectangle next= this.getRec();
        java.util.List<Tank> tanks = this.gamePanel.tankList;
        //子弹和Tank
        for(Tank tank: tanks){
            if(tank.getRec().intersects(next)){
                System.out.println("hit tank");
                tank.alive = false;
                this.gamePanel.blastList.add(new BlastObj(tank.x-34, tank.y-14));
                this.gamePanel.tankList.remove(tank);
                this.gamePanel.removeList.add(this);
                break;

            }
        }
    }

    public void paintSelf(Graphics g){
        g.drawImage(img, x, y, null);
        go();
        hitBase();
        hitWall();
        hitTank();
    }
}
