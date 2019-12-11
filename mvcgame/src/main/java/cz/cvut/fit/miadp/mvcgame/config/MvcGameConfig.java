package cz.cvut.fit.miadp.mvcgame.config;

public class MvcGameConfig 
{
    public static final int MAX_X = 1280;
    public static final int MAX_Y = 720;
    
	public static final int CANNON_INIT_X = 10;
    public static final int CANNON_INIT_Y = 360;
    
    public static final int MOVE_STEP = 10;

	public static final double INFO_X = 10;
	public static final double INFO_Y = 10;

    public static final int MAX_ENEMIES = 10;
    public static final int CANNON_MAX_Y_MARGIN = 50;

    public static final float GRAVITY_STEP = 1.0f;
    public static final float POWER_STEP = 0.05f;
    public static final float ANGLE_STEP = 0.1f;

    public static final int TIMER_TICK = 5;
    public static final int COLLIDE_FACTOR = 20;
    public static final long COLLISION_LIFETIME = 1500;

    public static final int INIT_SCORE = 0;
    public static final float INIT_GRAVITY = 10.0f;
    public static final float INIT_POWER = 0.5f;
    public static final float INIT_ANGLE = 0.0f;

    public static final float INIT_ENEMY_JUMP_POWER = 0.5f;

    public static final float GRAVITY_DIVIDE_CONSTANT = 7000.0f;

    public static final int INVISIBILITY_TOLERANCE_X = 20;
    public static final int INVISIBILITY_TOLERANCE_Y = 100;

    public static final float FLOAT_COMPARISON_EPSILON = 0.00001f;
    public static final int FLOAT_ROUNDING_SCALE = 3;

}