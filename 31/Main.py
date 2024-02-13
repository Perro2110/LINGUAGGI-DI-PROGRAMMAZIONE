import sys
import argparse

from Auto import Auto
from Furgone import Furgone 
from Veicoli import Veicoli
from Noleggi import Noleggi
from Clienti import Clienti

class Main:
    def __init__(self,arg):
        self._arg = arg
    
    def main(self):
        veicoli = []
        clienti = []
        CodPrezzo = {}
        CodTarga  = {}
        TargaNumNol = {}

        try:
            f=open("veicoli.txt","r")
            line = f.readline().strip()
            while(line != ''):
                tok = line.split()
                cod = int(tok[0])
                tipo = str(tok[1])
                targa = str(tok[2])
                line = f.readline().strip()    
                modello = line
                line = f.readline().strip()    
                marca = line
                if (tipo == "auto"):
                    line = f.readline().strip()
                    tok = line.split()
                    capienzaBagagliaio = float(tok[0]) 
                    cilindrata = int(tok[1])
                    line = f.readline().strip()
                    categoria = str(line)
                    line = f.readline().strip()
                    costoGiornaliero = float(line)
                    v = Auto(cod, tipo, targa, modello, marca, costoGiornaliero,capienzaBagagliaio,cilindrata,categoria)
                if (tipo == "furgone"):
                    line = f.readline().strip()
                    tok = line.split()
                    rimorchio  = str(tok[0])
                    numPosti   = int(tok[1])
                    vanoCarico = str(tok[2])
                    line = f.readline().strip()
                    costoGiornaliero = float(line)   
                    v = Furgone(cod, tipo, targa, modello, marca, costoGiornaliero,rimorchio,numPosti,vanoCarico)
                TargaNumNol[targa]    = 0
                CodTarga[cod]  = targa
                CodPrezzo[cod] = costoGiornaliero
                veicoli.append(v)
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
                cognomeNome = line
                c = Clienti(cognomeNome)
                line = f.readline().strip()
                while(line != ''):
                    tok       = line.split()
                    codice    = int(tok[0])
                    numGiorni = int(tok[1])
                    n = Noleggi(codice,numGiorni)
                    c.addNoleggio(n)
                    c.incnumNoleggi()
                    TargaNumNol[CodTarga[codice]] = TargaNumNol[CodTarga[codice]]+1
                    if(c.getCostoMax() < CodPrezzo[codice]*numGiorni):
                        c.setCostoMax(CodPrezzo[codice]*numGiorni)
                    line = f.readline().strip()
                clienti.append(c)
                line = f.readline().strip()
            f.close()
        except IOError as i:
            print(i)
        except Exception as e:
            print(e) 
        
        print("tipo, targa, codice, modello, marca, costo giornaliero,bagagliaio, cilindrata, categoria, rimorchio, numero di posti,vano di carico")
        for v in veicoli:
            print(v)
        
        print()
        for c in clienti:
            print(c)

        targaaa = input("inserire Targa: ") 
        print(targaaa+" :"+str(TargaNumNol[targaaa]))

if __name__ == "__main__":
    g= Main(sys.argv)
    g.main()