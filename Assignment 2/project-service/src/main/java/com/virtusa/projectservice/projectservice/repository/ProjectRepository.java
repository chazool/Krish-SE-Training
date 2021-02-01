package com.chazool.projectservice.projectservice.repository;

import com.chazool.common.projectservice.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Chazool
 */
public interface ProjectRepository extends JpaRepository<Project, Integer> {

    @Modifying
    @Transactional
    @Query("update Project p set p.isActive=false where p.id = ?1")
   public int deactivateIsActive(int id);

    /***
     * The method used to fetch  Active or Inactive(delete) Project
     * Active = true | Inactive(delete) = false
     * @param isActive
     * @return List<Project>
     */
    public List<Project> findByIsActive(boolean isActive);

    /***
     * The method used to fetch Project using Budget ,
     *  Option = Filtering  - budget - less than or Equal - Input amount
     * @param budget
     * @return List<Project>
     */
    public List<Project> findByBudgetLessThanEqual(BigDecimal budget);

    /***
     * The method used to fetch Project using Budget ,
     *  Option = Filtering - budget - greater than or Equal - Input Amount
     * @param budget
     * @return List<Project>
     */
    public List<Project> findByBudgetGreaterThanEqual(BigDecimal budget);

    /***
     * The method used to fetch Project using Budget ,
     *  Option = Filtering -  budget -  less than - Input Amount
     * @param budget
     * @return List<Project>
     */
    public List<Project> findByBudgetLessThan(BigDecimal budget);

    /***
     * The method used to fetch Project using Budget ,
     *  Option = Filtering -  budget -  Greater than - Input Amount
     * @param budget
     * @return List<Project>
     */
    public List<Project> findByBudgetGreaterThan(BigDecimal budget);

    /***
     * The method used to fetch Project using Budget ,
     *  Option = Filtering -  budget -  equal- Input Amount
     * @param budget
     * @return List<Project>
     */
    public List<Project> findByBudget(BigDecimal budget);

    /***
     * The method used to fetch Project using Budget ,
     *  Option = Filtering -  budget - not equal - Input Amount
     * @param budget
     * @return List<Project>
     */
    public List<Project> findByBudgetNot(BigDecimal budget);


}
