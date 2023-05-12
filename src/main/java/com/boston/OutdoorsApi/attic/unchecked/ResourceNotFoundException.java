package com.boston.OutdoorsApi.attic.unchecked;

public class ResourceNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;


		private String resourceType;
		private String setResourceId;

		public ResourceNotFoundException()
		{


		}

		public ResourceNotFoundException(String string)
		{
			// TODO Auto-generated constructor stub

		}

		public void setResourceId(String string)
	    {
	        // TODO Auto-generated method stub
	        this.setResourceId = string;
	    }



	   public void setResoureType(String name)
	    {
	        // TODO Auto-generated method stub
	        this.resourceType = name;
	    }

//	    public String SetResourceId()
//	    {
//	        return setResourceId;
//	    }



	   public String getResourceType()
	    {
	        return resourceType;
	    }


		public String getResourceId(){
			return setResourceId;
		}


	}