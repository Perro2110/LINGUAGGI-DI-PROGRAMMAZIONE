import sys
import argparse

from SuperMercati import SuperMercati
from Cittadino import Cittadino
from Iper import Iper
from Clienti import Clienti
from Visite import Visite


class Main:
    def __init__(self,arg):
        self._arg = arg
    
    def main(self):
        supermercati = []
        clienti      = []
        CodSpese     = {}
        CodVisite    = {} 

        try:
            f=open("supermercati.txt","r")
            line = f.readline().strip()
            while(line != ''):
                tok = line.split()
                cod  = int(tok[0])
                tipo = str(tok[1])
                line = f.readline().strip()
                indirizzo = line
                if(tipo == "cittadino"):
                    line = f.readline().strip()
                    tok = line.split()
                    orarioApertura = int(tok[0])
                    orarioChiusura = int(tok[1])
                    superficie = float(tok[2])
                    numAddetti = int(tok[3])
                    s = Cittadino(cod, tipo, indirizzo, superficie, numAddetti,orarioApertura,orarioChiusura)
                if(tipo == "iper"):
                    line = f.readline().strip()
                    tok = line.split()
                    superficie = float(tok[0])
                    numAddetti = int(tok[1])
                    line = f.readline().strip()
                    nomeCentro = line
                    s = Iper(cod, tipo, indirizzo, superficie, numAddetti,nomeCentro)
                supermercati.append(s)
                CodSpese  [cod]=0
                CodVisite [cod]=0
                line = f.readline().strip()                
            f.close()
        except IOError as i:
            print(i)
        except Exception as e:
            print(e)      

        try:
            f=open("clienti.txt","r")
            line = f.readline().strip()
            while(line != ''):
                cognome = line
                line = f.readline().strip()                
                nome = line
                c = Clienti(cognome,nome)
                line = f.readline().strip()
                tot = 0
                while(line != ''):
                    tok = line.split()
                    cod = int(tok[0])
                    importo = float(tok[1])
                    tot += importo
                    v = Visite(cod,importo)
                    c.addVisita(v)
                    line = f.readline().strip()
                    CodSpese  [cod] = CodSpese  [cod] + importo
                    CodVisite [cod] = CodVisite[cod]+1
                c.setSpesaTot(tot)
                clienti.append(c)
                line = f.readline().strip()
            f.close()
        except IOError as i:
            print(i)
        except Exception as e:
            print(e)   

        print("codice, tipo, indirizzo, apertura, chiusura, superficie, n.addetti, centro commerciale")
        for s in supermercati:
            print(s)
        
        print("cognome, nome, spesa totale")
        for c in clienti:
            print(c)

        print(str(sys.argv[1])+" "+str(CodSpese[int(sys.argv[1])]/CodVisite[int(sys.argv[1])]))
        
  
if __name__ == "__main__":
    g= Main(sys.argv)
    g.main()