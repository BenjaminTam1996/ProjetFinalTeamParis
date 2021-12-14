package musifan.musifan.entity;

public class JsonViews {
	public static class Common{
		
	}
	
	public static class LieuAvecConcert extends Common{
		
	}
	
	public static class ConcertAvecLieu extends Common{
		
	}
	
	public static class ConcertComplet extends ConcertAvecLieu {
		
	}
	
	public static class UtilisateurAvecArtiste extends ArtisteComplet {
		
	}
	
	public static class UtilisateurAvecPublicationsArtiste extends UtilisateurAvecArtiste {
		
	}
	
	public static class UtilisateurAvecAlbumsArtiste extends UtilisateurAvecArtiste {
		
	}
	
	public static class UtilisateurAvecCommandes extends Common {
		
	}
	
	public static class ArtisteComplet extends Common {
		
	}
	
	public static class CommandeAvecConsert extends Common {
		
	}
	
	
	public static class AlbumAvecArtistes extends Common{
		
	}
	

	public static class AlbumComplet extends AlbumAvecArtistes {
		
	}
}

