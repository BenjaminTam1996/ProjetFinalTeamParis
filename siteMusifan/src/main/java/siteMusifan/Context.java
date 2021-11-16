package siteMusifan;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Context {

		private static Context singleton = null;
		private EntityManagerFactory emf = null;

		private Context() {
			emf = Persistence.createEntityManagerFactory("siteMusifan");
		}

		public static Context getInstance() {
			if (singleton == null) {
				singleton = new Context();
			}
			return singleton;
		}

		public static void destroy() {
			if (singleton != null) {
				singleton.emf.close();
				singleton = null;
			}
		}

		public EntityManagerFactory getEntityManagerFactory() {
			return emf;
		}
}
