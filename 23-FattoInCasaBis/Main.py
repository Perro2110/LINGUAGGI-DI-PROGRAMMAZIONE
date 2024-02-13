# 8:26

import sys
import argparse

from Pantaloni import Pantaloni
from Giacca import Giacca
from Negozi import Negozi
from Elemento import Elemento
from Articoli import Articoli


class Main:
    def __init__(self,arg):
        self._arg = arg
    
    def main(self):
        articoli = []
        negozi   = []
        CodNum   = {}

        try:
            f=open("articoli.txt","r")
            line = f.readline().strip()
            while(line != ''):
                tok = line.split()
                cod = int(tok[0])
                tipo = str(tok[1])
                line = f.readline().strip()
                marca = line
                if(tipo == "pantaloni"):
                    line = f.readline().strip()
                    taglia = line
                    line = f.readline().strip()
                    modello = line
                    line = f.readline().strip()
                    tok = line.split()
                    costo = float(tok[0])
                    numTasche = int(tok[1])
                    scontoInPercentuale = int(tok[2])
                    a =Pantaloni(cod, tipo, marca, taglia, modello, costo, scontoInPercentuale,numTasche)
                if(tipo == "giacca"):
                    line = f.readline().strip()
                    tok = line.split()
                    taglia = str(tok[0])
                    peso   = int(tok[1])
                    line = f.readline().strip()
                    modello = line
                    line = f.readline().strip()
                    tok = line.split()
                    costo = float(tok[0])
                    scontoInPercentuale=int(tok[1])
                    a =Giacca(cod, tipo, marca, taglia, modello, costo, scontoInPercentuale,peso)
                CodNum[cod] = 0
                articoli.append(a)
                line = f.readline().strip()
            f.close()
        except IOError as i:
            print(i)
        except Exception as e:
            print(e)   

        try:
            f=open("negozi.txt","r")
            line = f.readline().strip()
            while(line != ''):
                codice = int(line)
                line = f.readline().strip()
                nome = line
                line = f.readline().strip()
                indirizzo = line
                line = f.readline().strip()
                tok = line.split()
                n = Negozi(codice,nome,indirizzo)
                
                for i in range(len(tok)//2):
                    cod=int(tok[i*2])
                    quantita=int(tok[i*2+1])
                    e = Elemento(cod,quantita)
                    n.addElemento(e)
                    CodNum[cod] = CodNum[cod] + quantita
                
                negozi.append(n)
                line = f.readline().strip()
            f.close()
        except IOError as i:
            print(i)
        except Exception as e:
            print(e)  
        
        
        print("tipo, codice, marca, modello, taglia, tasche, peso, costo, sconto")
        for a in articoli:
            print(a)
        print("")
        print("codice, nome, indirizzo, numero articoli, magazzino")
        for n in negozi:
            print(n)

        cod = int(sys.argv[1])
        print(str(CodNum[cod]))

        
  
if __name__ == "__main__":
    g= Main(sys.argv)
    g.main()