int main(int argc, char *argv[])
{
	long double a, i, b, c, d=0;
	a=atof(argv[1]);
	if( argc == 2){
		for (i=2; i<a; i++){
			if( a/i==1){
				d=d+1;
			}	
		}
		if(a==i)
	printf("%l \t es un numero primo \n",a);
		else
	printf("Estaba en el numero %d del numero %l \n",d,a);
	}
	if( argc == 4) {
		b= atof(argv[2]);
		c= atof(argv[3]);
		for (i=b; i<c; i++){
			if (a / i == 1)
				break;
		}
		if ( c==a-1 ){
			if (i==c)
	printf("en este rango no se encontro factor para\t %l \n ",a);
				
			else
	printf("No es un numero primo ya que \t %l \t es factor de \t %l \n",i,a);
		}else{
			if (i==c)
	printf("en este rango no se encontro factor para\t %l \n",a);
			else
	printf("No es un numero primo ya que \t %l \t es factor de \t %l \n",i,a);
		}
	}
return 0;
}