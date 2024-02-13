import sys
import argparse

from Veicoli import Veicoli
from Roulotte import Roulotte
from Caravan import Caravan
from Clienti import Clienti
from Noleggi import Noleggi

class Main:
    def __init__(self,arg):
        self._arg = arg
    
    def main(self):
        veicoli  = []
        clienti  = []
        CodVolt  = {}
        CodPrezo = {}
        try:
            f=open("veicoli.txt","r")
            line = f.readline().strip()
            while(line != ''):
                tok  = line.split()
                cod  = int(tok[0])
                tipo = str(tok[1])
                line = f.readline().strip()
                marcaDelVeicolo = line
                if (tipo == "roulotte"):
                    line = f.readline().strip()
                    tok  = line.split()
                    peso = int(tok[0])
                    lunghezza = float(tok[1])
                    larghezza = float(tok[2])
                    postiLetto = int(tok[3])
                    line = f.readline().strip()
                    tok = line.split()
                    veranda = str(tok[0])
                    costoGiornaliero = float(tok[1])
                    v = Roulotte(cod, tipo, marcaDelVeicolo, lunghezza,larghezza, costoGiornaliero, postiLetto,peso,veranda)
                    CodVolt[cod]   = 0
                    CodPrezo[cod] = costoGiornaliero                 
                if (tipo == "caravan"):
                    line = f.readline().strip()
                    tok  = line.split()
                    larghezza  = float(tok[0])
                    lunghezza  = float(tok[1])
                    potenza    = int(tok[2])
                    postiLetto = int(tok[3])
                    costoGiornaliero = float(tok[4])
                    v = Caravan(cod, tipo, marcaDelVeicolo, lunghezza, larghezza, costoGiornaliero, postiLetto,potenza)
                    CodVolt[cod]   = 0
                    CodPrezo[cod] = costoGiornaliero 
                line = f.readline().strip()
                line = f.readline().strip()
                veicoli.append(v)
            f.close()
        except IOError as i:
            print(i)
        except Exception as e:
            print(e)

        try:
            f=open("clienti.txt","r")
            line = f.readline().strip()
            while(line != ''):
                cod  = int(line)
                line = f.readline().strip()                
                nome = str(line)
                line = f.readline().strip()  
                cognome = str(line)
                line = f.readline().strip()
                indirizzo = str(line)
                c = Clienti(cod,nome,cognome,indirizzo);
                line = f.readline().strip() 
               
                while(line != ''):
                    tok = line.split()
                    cod=int(tok[0])
                    NumGiorni=int(tok[1])
                    n = Noleggi(cod,NumGiorni)  
                    line = f.readline().strip()                     
                    c.addNoleggi(n)
                    CodVolt[cod]=CodVolt[cod]+NumGiorni

                line = f.readline().strip()                  
                clienti.append(c)  
            f.close()
        except IOError as i:
            print(i)
        except Exception as e:
            print(e)        
        
        print("tipo, codice, marca, larghezza, lunghezza, posti letto, peso,veranda, potenza, costo")
        for v in veicoli:
            print(v)

        print("codice, cognome, nome, indirizzo, prenotazioni")
        for c in clienti:
            print(c)
        print()
        for v in veicoli:
            print(str(v.getCod())+" "+str(CodVolt[v.getCod()]*CodPrezo[v.getCod()]))

              
if __name__ == "__main__":
    g= Main(sys.argv)
    g.main()