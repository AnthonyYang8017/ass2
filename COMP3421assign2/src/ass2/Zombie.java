package ass2;

import com.jogamp.opengl.GL2;

public class Zombie extends GameObject {

	private Cube myHead;
	private Cube myArmleft;
	private Cube myArmright;
	private Cube myTorso;
	private Cube mylegleft;
	private Cube mylegright;
	
	private double forward = 1;
	
	
	public Zombie(GameObject parent) {
		super(parent);
		setMyHead(new Cube(this));
		double[] scale = new double[]{0.4,0.4,0.4};
		double[] rotation = new double[]{0,0,0};
		double[] Position = new double[]{0,1.8,0};
		getMyHead().setPosition(Position);
		getMyHead().setScale(scale);
		getMyHead().setRotation(rotation);
		
		myTorso = new Cube(this);
		scale = new double[]{0.4,0.6,0.2};
		rotation = new double[]{0,0,0};
		Position = new double[]{0,1,0};
		myTorso.setPosition(Position);
		myTorso.setScale(scale);
		myTorso.setRotation(rotation);
		
		
		//myArm
		myArmleft = new Cube(this);
		scale = new double[]{0.2,0.6,0.2};
		rotation = new double[]{90,0,0};
		Position = new double[]{0.6,1,0};
		myArmleft.setPosition(Position);
		myArmleft.setScale(scale);
		myArmleft.setRotation(rotation);
		
		myArmright = new Cube(this);
		scale = new double[]{0.2,0.6,0.2};
		rotation = new double[]{90,0,0};
		Position = new double[]{-0.6,1,0};
		myArmright.setPosition(Position);
		myArmright.setScale(scale);
		myArmright.setRotation(rotation);
		
		
		//myleg
		mylegleft = new Cube(this);
		scale = new double[]{0.2,0.6,0.19};
		rotation = new double[]{0,0,0};
		Position = new double[]{0.2,0,0};
		mylegleft.setPosition(Position);
		mylegleft.setScale(scale);
		mylegleft.setRotation(rotation);
		
		mylegright = new Cube(this);
		scale = new double[]{0.2,0.6,0.19};
		rotation = new double[]{0,0,0};
		Position = new double[]{-0.2,0,0};
		mylegright.setPosition(Position);
		mylegright.setScale(scale);
		mylegright.setRotation(rotation);
	}
	
	public void drawSelf(GL2 gl) {
		update(0);
		float[] ambient = {0f, 0.1f, 0.1f, 1.0f};
	    float[] diffuse = {0f, 0.2f, 0.2f, 1.0f};
	    float[] specular = {0.0f, 0.1f, 0.1f, 1.0f};
	    gl.glMaterialfv(GL2.GL_FRONT, GL2.GL_AMBIENT, ambient, 0);
	    gl.glMaterialfv(GL2.GL_FRONT, GL2.GL_DIFFUSE, diffuse, 0);
	    gl.glMaterialfv(GL2.GL_FRONT, GL2.GL_SPECULAR, specular, 0);
	    gl.glTranslated(0, -0.6, 0);
	}
	
	@Override
    public void update(double dt) {
		double[] angle1 = new double[]{0,0,0};
		double[] angle2 = new double[]{0,0,0};
		double[] angle3 = new double[]{0,0,0};
		double[] angle4 = new double[]{0,0,0};
	   
    	double tem = myArmleft.getRotation()[0];
    	if(tem>110 || tem<70){
    		forward = -forward;
    	}
		angle1 = new double[]{1*forward*Game.speed*30,0,0};
		angle2 = new double[]{-1*forward*Game.speed*30,0,0};
		myArmleft.rotate(angle1);
    	myArmright.rotate(angle2);
    	angle3 = new double[]{1*forward*Game.speed*80,0,0};
    	angle4 = new double[]{-1*forward*Game.speed*80,0,0};
    	mylegright.rotate(angle3);
    	mylegleft.rotate(angle4);
	}

	public Cube getMyHead() {
		return myHead;
	}

	public void setMyHead(Cube myHead) {
		this.myHead = myHead;
	}

}
