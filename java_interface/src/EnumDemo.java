
public enum FlightCrewJob {
	Flight_Attendent, Copilot, Pilot;
}

class CrewMember {
	FlightCrewJob job;
	String name;

	public FlightCrewJob getJob() {
		return job;
	}

	public String getName() {
		return name;
	}

	CrewMember(FlightCrewJob job, String name) {
		this.job = job;
		this.name = name;
	}
}

public class EnumDemo {

	public static void main(String[] args) {
		
		CrewMember ajit = new CrewMember(FlightCrewJob.Copilot,"Ajit");
		CrewMember sandip = new CrewMember(FlightCrewJob.Pilot,"Sandip");
		
		 public  void whoIsInCharge(CrewMember M1, CrewMember M2) {
			CrewMember theBoss = M1.getJob().compareTo(M2.getJob())>0 ? M1:M2 ;
			
			return System.out.println(theBoss.getName() +" is in charge!!");	
		}
		whoIsInCharge(ajit,sandip);	 
	}
}
