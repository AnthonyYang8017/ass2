package ass2;

import com.jogamp.opengl.GL2;

public class Cube extends GameObject {

	private MyTexture texture;
	
	private static double vertices[] = 
		{
			1.0, -1.0, 1.0, 
			1.0, 1.0, 1.0, 
			1.0, 1.0, -1.0, 
			1.0, -1.0, -1.0, 
			-1.0, -1.0, 1.0, 
			-1.0, 1.0, 1.0, 
			-1.0, 1.0, -1.0, 
			-1.0, -1.0, -1.0
		};

		// Vertex indices of each box side, 6 groups of 4.
		private static int quadIndices[] = 
		{
		    3, 2, 1, 0, //right face
		    7, 6, 2, 3, //back face
		    4, 5, 6, 7, //left face
			0, 1, 5, 4, //front face
			4, 7, 3, 0, //bottom face
			6, 5, 1, 2  //top face
		};

		
		//Face normals = normalized unit vector pointing in direction of face
		static double faceNormals[] = {
			 1, 0, 0,  //right face
			 0, 0,-1,  //back face
			-1, 0, 0,  //left face
			 0, 0, 1,  //front face
			 0,-1, 0,  //bottom face
		     0, 1, 0   //top face
		};
	
	public Cube(GameObject parent) {
		super(parent);
	}
	
	
	public void setTexture(MyTexture tex){
		//System.out.println(tex.getTextureId());
		texture = tex;
	}
	
	//gets the texture S coord at corner i
	public int texS(int i){
		if (i == 1 || i == 2)
			return 0;
		else
			return 1;
	}
	
	//gets the texture T coord at corner i
	public int texT(int i){
		if (i == 1 || i == 3)
			return 0;
		else
			return 1;
	}
	

	public void drawSelf(GL2 gl) {
		gl.glPushMatrix();
		gl.glTranslated(0, -0.7, 0);

		gl.glBindTexture(GL2.GL_TEXTURE_2D, texture.getTextureId());
	    gl.glBegin(GL2.GL_QUADS);{
         	//Draw 6 faces of box (each with 4 vertices)
         	for(int i=0; i< 24; i++){
         		int index = quadIndices[i];  
         		//The same normal is used for all 4 vertices
         		//in a face
         		gl.glNormal3dv(faceNormals,(i/4)*3);
         		gl.glTexCoord2d(texS(i%4), texT(i%4));
         		gl.glVertex3dv(vertices,index*3);
         	}
         }gl.glEnd();
	    
	    gl.glPopMatrix();
	    gl.glPolygonMode(GL2.GL_FRONT_AND_BACK, GL2.GL_FILL);
		
	}
}
