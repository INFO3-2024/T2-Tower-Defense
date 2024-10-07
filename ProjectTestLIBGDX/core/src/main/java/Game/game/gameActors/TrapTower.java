
		

package Game.game.gameActors;


import Game.game.gameAssets.TowerTexture;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Array;

import Game.game.gameActors.Tower;
import Game.game.gameActors.Bullet;
import java.util.ArrayList;

public class TrapTower extends Tower {
    private TowerTexture towerTexture;
    private int currentFrame; // Frame atual para a animação
    private float towerAngle = 0f; 
	private Texture imagem; 

	//construtor
    public TrapTower(int positionX, int positionY) {
		//inicialização das variáveis 
        setPosition(positionX, positionY);
        this.towerTexture = TowerTexture.getInstance();
        this.currentFrame = 0;  // Inicializa o frame como 0
		imagem = TowerTexture.getInstance().getTexture("TrapTower"); 
        fireRate = 3;
        shootingRange = 800;
        projectileSpeed = 10;
        damage = 3;
        bulletTipe = Game.game.gameActors.bulletTipe.NORMAL_PROJECTILE;
    }

    // Implementação temporária de tiro
    public ArrayList<Bullet> tryToShoot(Array<Actor> listaAtores) {
        checkEnemiesInRange(listaAtores);
        Vector2 positionToGo = getFarthestEnemyPosition();

        if(positionToGo != null) {
            updateTowerAngle(positionToGo); 
        }
        elapsedTime += Gdx.graphics.getDeltaTime();

        if (!enemiesInRange.isEmpty() && elapsedTime >= fireRate) {
            elapsedTime = 0;
            bulletsArray.add(new Bullet(this.getX(), this.getY(), positionToGo.x, positionToGo.y, projectileSpeed, damage, bulletTipe));

            // Altera o frame para simular a animação no disparo
            currentFrame = (currentFrame + 1) % 40;
        }

        return bulletsArray;
    }

    

     //função para atalização do angulo da torre
     private void updateTowerAngle(Vector2 enemyPosition){

        //Declaração da posição da torre
        Vector2 towerPosition = new Vector2(getX(), getY());

        //Calcumo da direção da torre em relaçõ a posição do inimigo
        Vector2 direction = enemyPosition.sub(towerPosition); 

        //calculo do angulo 
        if(direction.len() > 0){
            direction.nor(); 
            towerAngle = MathUtils.atan2(direction.y, direction.x) * MathUtils.radiansToDegrees;
        }
     }

     @Override
     public void draw(Batch batch, float parentAlpha) {
         // Desenha o frame correspondente da TrapTower com base no currentFrame
         batch.draw(imagem,getX(),getY(),
         imagem.getWidth()/2,imagem.getHeight()/2, imagem.getWidth(), imagem.getHeight(),
         1,1,//escala 
         towerAngle);//resultado do calculo --> angulo calculado; 
     }

     
}