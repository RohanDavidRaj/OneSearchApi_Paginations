# OneSearchApi_Paginations
-------one api for search (repository method ) and  paginations methods---------

jpa methods -> Double filteredSalary = salary != null ? salary : Double.MIN_VALUE; -> this is use for null avoidence 
              dao.findByNameOrDesignationOrSalary(name, designation, filteredSalary);

Pagination-> dao.findAll(PageRequest.of(offset, pageSize));
            dao.findAll(PageRequest.of(offset, pageSize).withSort(Direction.ASC, field)); -> pagination with sorted


              
