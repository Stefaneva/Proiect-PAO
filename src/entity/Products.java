package entity;

public class Products {
	private int idProd;
	private String denumire;
	private String stoc;
	private int pret;
	private String categorie;
	private String descriere;
	private int nrStoc;
	public Products(){
		
	}
	public Products(String denumire,String stoc,int pret,String categorie,String descriere,int nrStoc)
	{
		//this.idProd=idProd;
		this.denumire=denumire;
		this.stoc=stoc;
		this.pret=pret;
		this.categorie=categorie;
		this.descriere=descriere;
		this.nrStoc=nrStoc;
	}
	
	
	public int getIdProd() {
		return idProd;
	}
	public void setIdProd(int idProd) {
		this.idProd = idProd;
	}
	public String getDenumire() {
		return denumire;
	}
	public void setDenumire(String denumire) {
		this.denumire = denumire;
	}
	public String getStoc() {
		return stoc;
	}
	public void setStoc(String stoc) {
		this.stoc = stoc;
	}
	public int getPret() {
		return pret;
	}
	public void setPret(int pret) {
		this.pret = pret;
	}
	public String getCategorie() {
		return categorie;
	}
	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}
	public String getDescriere() {
		return descriere;
	}
	public void setDescriere(String descriere) {
		this.descriere = descriere;
	}
	public int getNrStoc() {
		return nrStoc;
	}
	public void setNrStoc(int nrStoc) {
		this.nrStoc = nrStoc;
	}
	@Override
	public String toString(){
		return this.getDenumire()+" "+this.getPret()+" "+this.getDescriere()+" "+this.getStoc();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categorie == null) ? 0 : categorie.hashCode());
		result = prime * result + ((denumire == null) ? 0 : denumire.hashCode());
		result = prime * result + ((descriere == null) ? 0 : descriere.hashCode());
		result = prime * result + idProd;
		result = prime * result + nrStoc;
		result = prime * result + pret;
		result = prime * result + ((stoc == null) ? 0 : stoc.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Products other = (Products) obj;
		if (categorie == null) {
			if (other.categorie != null)
				return false;
		} else if (!categorie.equals(other.categorie))
			return false;
		if (denumire == null) {
			if (other.denumire != null)
				return false;
		} else if (!denumire.equals(other.denumire))
			return false;
		if (descriere == null) {
			if (other.descriere != null)
				return false;
		} else if (!descriere.equals(other.descriere))
			return false;
		if (idProd != other.idProd)
			return false;
		if (nrStoc != other.nrStoc)
			return false;
		if (pret != other.pret)
			return false;
		if (stoc == null) {
			if (other.stoc != null)
				return false;
		} else if (!stoc.equals(other.stoc))
			return false;
		return true;
	}
	
}
