# -- coding: utf-8 --
import urllib.request

for i in range (1, 36):
    print ("Extrayendo el Capitulo "+ str(i))
    urllib.request.urlretrieve('http://www.elmundo.es/quijote/capitulo.html?cual='+ str(i), 'Capitulo'+ str(i)+'.txt')
else:
    print ("Ya extraje todo")
    
    
