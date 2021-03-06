/* Copyright 2017 Paul Bouman
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the  
 * "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR
 * ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH
 * THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 * 
 * In case you use this software for research purposes, it is appreciated if you provide a citation of the following paper:
 * 
 * N.A.H. Agatz, P.C. Bouman & M.E. Schmidt. Optimization Approaches for the Traveling Salesman Problem with Drone. Transportation Science.
 * 
 * The paper still has to appear, but was accepted for publication. This notice will be updated with a more detailed reference if that
 * information is available.
 */

package nl.rsm.tom.drones.solver;

import java.util.Collections;
import java.util.Map;

import nl.rsm.tom.drones.data.Solution;
import nl.rsm.tom.drones.data.instance.Instance;

/**
 * Interface for solvers of the problem.
 * @author Paul Bouman
 *
 * @param <E> the types of locations that are processed.
 */

public interface Solver<E>
{
	/**
	 * Themethod used for solving an instance. It accepts an instance
	 * and produces a solution, or null if no solution was found.
	 * @param instance The instance to be solved
	 * @return The solution found, or null if no solution was found.
	 */
	public Solution<E> solve(Instance<E> instance);
	
	/**
	 * When the solver is running, statistics can be collected.
	 * These should be stored in a map for reporting purposes.
	 * This method should return relevant statitics for the last
	 * time the solver instance solved an instance.
	 * When the solver has never run yet, it should return
	 * a map with the keys of the statistics which will be
	 * reported by the solver after running.
	 * The default behavior is that no statistics are collected.
	 * @return The map containing solver statistics
	 */
	default public Map<String,Object> getLastSolverStatistics()
	{
		return Collections.emptyMap();
	}

}
