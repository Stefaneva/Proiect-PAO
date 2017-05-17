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
	public Products(int idProd,String denumire,String stoc,int pret,String categorie,String descriere,int nrStoc)
	{
		this.idProd=idProd;
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
}
