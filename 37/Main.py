import sys
import argparse

from Campi import Campi
from Tennis import Tennis
from Squash import Squash
from Prenotazioni import Prenotazioni
from Giocatori import Giocattori

class Main:
    def __init__(self,arg):
        self._arg = arg
    
    def main(self):
        campi     = []
        giocatori = []
        CodCosto  = {}
        CodOre    = {}
        try:
            f=open("campi.txt","r")
            line = f.readline().strip()
            while(line != ''):
                tok = line.split()
                codice = int(tok[0])
                sport  = str(tok[1])
                line = f.readline().strip() 
                nomeCampo = line
                if(sport == "tennis"):
                    line = f.readline().strip() 
                    tok= line.split()
                    larghezza = float(tok[0])
                    lunghezza = float(tok[1])
                    tempMedia = float(tok[2])
                    line = f.readline().strip() 
                    terreno = line
                    line = f.readline().strip() 
                    costoOrario = float(line)
                    c = Tennis(codice, sport, nomeCampo, larghezza, lunghezza, costoOrario,tempMedia,terreno)                    
                if(sport == "squash"):
                    line = f.readline().strip() 
                    tok= line.split()
                    larghezza   = float(tok[0])
                    lunghezza   = float(tok[1])
                    altezza     = float(tok[2])
                    piano       = int(tok[3])
                    costoOrario = float(tok[4]) 
                    c = Squash(codice,sport, nomeCampo, larghezza, lunghezza, costoOrario,altezza,piano)
                line = f.readline().strip()
                campi.append(c)
                CodCosto[codice] = costoOrario
                CodOre[codice]   = 0
            f.close()
        except IOError as i:
            print(i)
        except Exception as e:
            print(e)

        try:
            f=open("giocatori.txt","r")
            line = f.readline().strip()
            while(line != ''):
                codiceSocio  = int(line)
                line         = f.readline().strip()
                nomeEcognome = line
                line         = f.readline().strip()
                tok          = line.split()
                eta          = int(tok[0])
                categoria    = int(tok[1])
                
                g = Giocattori(codiceSocio,nomeEcognome,eta,categoria)
                line         = f.readline().strip()
                tok          = line.split()
                for i in range(len(tok)//2):
                    cod=int(tok[i*2])
                    oreInizio=int(tok[i*2+1])
                    p = Prenotazioni(cod,oreInizio)
                    g.addPrenotazione(p)
                    CodOre[cod] = CodOre[cod] +1
                giocatori.append(g) 
                line = f.readline().strip()
            f.close()
        except IOError as i:
            print(i)
        except Exception as e:
            print(e)
        
        print("sport, nome del campo, codice, larghezza, lunghezza,temperatura, terreno, altezza, piano, costo")
        for c in campi:
            print(c)

        print("codice, nome e cognome, età, categoria, prenotazioni")
        for g in giocatori:
            print(g)
        
        print(str(sys.argv[1]),str(CodOre[int(sys.argv[1])] * CodCosto[int(sys.argv[1])]))


if __name__ == "__main__":
    g= Main(sys.argv)
    g.main()



