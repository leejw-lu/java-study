package tv;

public class watchTV {

	public static void main(String[] args) {
		// 건들지 말기
		TV tv = new TV( 7, 20, false);  	
        
        tv.status();	
        
        tv.power( true );
        tv.volume( 120 );
        tv.status();		          
        
        tv.volume( false ); 	//오버로딩을 구현해야함.
        tv.status();
        
        tv.channel( 0 );
        tv.status();		          
        
        tv.channel( true );
        tv.channel( true );
        tv.channel( true );
        tv.status();

        tv.power( false );
        tv.status();     

	}

}
