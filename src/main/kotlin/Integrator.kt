import SLAE_methods_functions.SLAEAccurateMethods
import java.lang.Math.*

class Integrator() {

    fun leftRectangle(f: (Double) -> Double, a: Double, b: Double, h: Double): Double {
        var s = 0.0
        var cPos = a
        while(cPos + h < b) {
            s += f(cPos)*h
            cPos += h
        }
        s += f(cPos)*(b-cPos)

        return s
    }

    fun midRectangle(f: (Double) -> Double, a: Double, b: Double, h: Double): Double {
        var s = 0.0
        var cPos = a
        while(cPos + h < b) {
            s += f(cPos + h/2)*h
            cPos += h
        }
        s += f((cPos+b)/2)*(b-cPos)

        return s
    }
    fun trapezoid(f: (Double) -> Double, a: Double, b: Double, h: Double): Double {

        var s = 0.0
        var cPos = a
        while(cPos + h < b) {
            s += (f(cPos)+f(cPos+h))*h/2
            cPos += h
        }
        s += (f(cPos) + f(b))*(b-cPos)/2

        return s
    }
    fun simson(f: (Double) -> Double, a: Double, b: Double, h: Double):Double {

        var s = 0.0
        var cPos = a
        while(cPos + h < b) {
            s += h/6*(f(cPos) + 4*f(cPos+h/2) + f(cPos+h))
            cPos += h
        }
        s += (b-cPos)/6*(f(cPos) + 4*f((cPos+b)/2) + f(b))

        return s
    }

    fun gauss(f: (Double) -> Double, a: Double, b: Double, h: Double): Double {

        var s = 0.0
        var cPos = a

        while(cPos + h < b) {
            //1: вычисление моментов (можно обобщить вычисления для различных особенностей, но в контексте задачи просто привел аналитическое решение)
            val moments = DoubleArray(6) { 0.0 }
            moments[0] = 4.0/3.0*pow(cPos + h - a, 3.0/4.0) - 4.0/3.0*pow(cPos - a, 3.0/4.0)
            moments[1] = 4.0/7.0*pow(cPos + h - a, 7.0/4.0) + a*4.0/3.0*pow(cPos + h - a, 3.0/4.0) - (4.0/7.0*pow(cPos - a, 7.0/4.0) + a*4.0/3.0*pow(cPos - a, 3.0/4.0))
            moments[2] = 4.0/11.0*pow(cPos + h - a, 11.0/4.0) + 2*a*4.0/7.0*pow(cPos + h - a, 7.0/4.0) + pow(a, 2.0)*4.0/3.0*pow(cPos + h - a, 3.0/4.0) - (4.0/11.0*pow(cPos - a, 11.0/4.0) + 2*a*4.0/7.0*pow(cPos - a, 7.0/4.0) + pow(a, 2.0)*4.0/3.0*pow(cPos - a, 3.0/4.0))
            moments[3] = 4.0/15.0*pow(cPos + h - a, 15.0/4.0) + 3*a*4.0/11.0*pow(cPos + h - a, 11.0/4.0) + 3*pow(a, 2.0)*4.0/7.0*pow(cPos + h - a, 7.0/4.0) + pow(a, 3.0)*4.0/3.0*pow(cPos + h - a, 3.0/4.0) - (4.0/15.0*pow(cPos - a, 15.0/4.0) + 3*a*4.0/11.0*pow(cPos - a, 11.0/4.0) + 3*pow(a, 2.0)*4.0/7.0*pow(cPos - a, 7.0/4.0) + pow(a, 3.0)*4.0/3.0*pow(cPos - a, 3.0/4.0))
            moments[4] = 4.0/19.0*pow(cPos + h - a, 19.0/4.0) + 4*a*4.0/15.0*pow(cPos + h - a, 15.0/4.0) + 6*pow(a, 2.0)*4.0/11.0*pow(cPos + h - a, 11.0/4.0) + 4*pow(a, 3.0)*4.0/7.0*pow(cPos + h - a, 7.0/4.0) + pow(a, 4.0)*4.0/3.0*pow(cPos + h - a, 3.0/4.0) - (4.0/19.0*pow(cPos - a, 19.0/4.0) + 4*a*4.0/15.0*pow(cPos - a, 15.0/4.0) + 6*pow(a, 2.0)*4.0/11.0*pow(cPos - a, 11.0/4.0) + 4*pow(a, 3.0)*4.0/7.0*pow(cPos - a, 7.0/4.0) + pow(a, 4.0)*4.0/3.0*pow(cPos - a, 3.0/4.0))
            moments[5] = 4.0/23.0*pow(cPos + h - a, 23.0/4.0) + 5*a*4.0/19.0*pow(cPos + h - a, 19.0/4.0) + 10*pow(a, 2.0)*4.0/15.0*pow(cPos + h - a, 15.0/4.0) + 10*pow(a, 3.0)*4.0/11.0*pow(cPos + h - a, 11.0/4.0) + 5*pow(a, 4.0)*4.0/7.0*pow(cPos + h - a, 7.0/4.0) + pow(a, 5.0)*4.0/3.0*pow(cPos + h - a, 3.0/4.0) - (4.0/23.0*pow(cPos - a, 23.0/4.0) + 5*a*4.0/19.0*pow(cPos - a, 19.0/4.0) + 10*pow(a, 2.0)*4.0/15.0*pow(cPos - a, 15.0/4.0) + 10*pow(a, 3.0)*4.0/11.0*pow(cPos - a, 11.0/4.0) + 5*pow(a, 4.0)*4.0/7.0*pow(cPos - a, 7.0/4.0) + pow(a, 5.0)*4.0/3.0*pow(cPos - a, 3.0/4.0))

            //2: рещение СЛАУ и нахождение коэфициентов a_i.
            val matrix = arrayOf<DoubleArray>(moments.copyOfRange(0, 3), moments.copyOfRange(1, 4), moments.copyOfRange(2, 5))
            val bs = arrayOf<DoubleArray>(doubleArrayOf(-1*moments[3]), doubleArrayOf(-1*moments[4]), doubleArrayOf(-1*moments[5]))
            val aCoef = SLAEAccurateMethods.GaussMethod(matrix, bs)

            //нахождение узлов x_i как корней узлового многочлена (по формуле Кордано)
            val p: Double = (aCoef[1][0] - aCoef[2][0]*aCoef[2][0]/3)
            val q: Double = 2*pow(aCoef[2][0], 3.0)/27 - aCoef[2][0]*aCoef[1][0]/3 + aCoef[0][0]
            var delta: Double = pow(q/2, 2.0) + pow(p/3, 3.0)

            var phi: Double
            if(q < 0) phi = atan(sqrt(-1*delta)/(-1*q/2))
            else if(q > 0) phi = atan(sqrt(-1*delta)/(-1*q/2)) + PI
            else phi = PI/2

            val x = mutableListOf<Double>(2*sqrt(-1*p/3)*cos(phi/3) - aCoef[2][0]/3, 2*sqrt(-1*p/3)*cos(phi/3+ PI*2/3) - aCoef[2][0]/3, 2*sqrt(-1*p/3)*cos(phi/3+ PI*4/3) - aCoef[2][0]/3)
            //Знаем, что корня точно 3 различных или с вещественной парой, нашли по Кардано. Теперь находим A_i решением слау и уповаем,что не выйдет ошибок

            val fMatrix = arrayOf<DoubleArray>(doubleArrayOf(1.0, 1.0, 1.0), x.toDoubleArray(), doubleArrayOf(x[0]*x[0], x[1]*x[1], x[2]*x[2]))
            val fb = arrayOf<DoubleArray>(doubleArrayOf(moments[0]), doubleArrayOf(moments[1]), doubleArrayOf(moments[2]))
            val A = SLAEAccurateMethods.GaussMethod(fMatrix, fb)

            s += f(x[0])*A[0][0] + f(x[1])*A[1][0] + f(x[2])*A[2][0]

            cPos += h
        }

        //1: вычисление моментов (можно обобщить вычисления для различных особенностей, но в контексте задачи просто привел аналитическое решение)
        //h = b - cPos
        val moments = DoubleArray(6) { 0.0 }
        moments[0] = 4.0/3.0*pow(b - a, 3.0/4.0) - 4.0/3.0*pow(cPos - a, 3.0/4.0)
        moments[1] = 4.0/7.0*pow(b - a, 7.0/4.0) + a*4.0/3.0*pow(b - a, 3.0/4.0) - (4.0/7.0*pow(cPos - a, 7.0/4.0) + a*4.0/3.0*pow(cPos - a, 3.0/4.0))
        moments[2] = 4.0/11.0*pow(b - a, 11.0/4.0) + 2*a*4.0/7.0*pow(b - a, 7.0/4.0) + pow(a, 2.0)*4.0/3.0*pow(b - a, 3.0/4.0) - (4.0/11.0*pow(cPos - a, 11.0/4.0) + 2*a*4.0/7.0*pow(cPos - a, 7.0/4.0) + pow(a, 2.0)*4.0/3.0*pow(cPos - a, 3.0/4.0))
        moments[3] = 4.0/15.0*pow(b - a, 15.0/4.0) + 3*a*4.0/11.0*pow(b - a, 11.0/4.0) + 3*pow(a, 2.0)*4.0/7.0*pow(b - a, 7.0/4.0) + pow(a, 3.0)*4.0/3.0*pow(b - a, 3.0/4.0) - (4.0/15.0*pow(cPos - a, 15.0/4.0) + 3*a*4.0/11.0*pow(cPos - a, 11.0/4.0) + 3*pow(a, 2.0)*4.0/7.0*pow(cPos - a, 7.0/4.0) + pow(a, 3.0)*4.0/3.0*pow(cPos - a, 3.0/4.0))
        moments[4] = 4.0/19.0*pow(b - a, 19.0/4.0) + 4*a*4.0/15.0*pow(b - a, 15.0/4.0) + 6*pow(a, 2.0)*4.0/11.0*pow(b - a, 11.0/4.0) + 4*pow(a, 3.0)*4.0/7.0*pow(b - a, 7.0/4.0) + pow(a, 4.0)*4.0/3.0*pow(b - a, 3.0/4.0) - (4.0/19.0*pow(cPos - a, 19.0/4.0) + 4*a*4.0/15.0*pow(cPos - a, 15.0/4.0) + 6*pow(a, 2.0)*4.0/11.0*pow(cPos - a, 11.0/4.0) + 4*pow(a, 3.0)*4.0/7.0*pow(cPos - a, 7.0/4.0) + pow(a, 4.0)*4.0/3.0*pow(cPos - a, 3.0/4.0))
        moments[5] = 4.0/23.0*pow(b - a, 23.0/4.0) + 5*a*4.0/19.0*pow(b - a, 19.0/4.0) + 10*pow(a, 2.0)*4.0/15.0*pow(b - a, 15.0/4.0) + 10*pow(a, 3.0)*4.0/11.0*pow(b - a, 11.0/4.0) + 5*pow(a, 4.0)*4.0/7.0*pow(b - a, 7.0/4.0) + pow(a, 5.0)*4.0/3.0*pow(b - a, 3.0/4.0) - (4.0/23.0*pow(cPos - a, 23.0/4.0) + 5*a*4.0/19.0*pow(cPos - a, 19.0/4.0) + 10*pow(a, 2.0)*4.0/15.0*pow(cPos - a, 15.0/4.0) + 10*pow(a, 3.0)*4.0/11.0*pow(cPos - a, 11.0/4.0) + 5*pow(a, 4.0)*4.0/7.0*pow(cPos - a, 7.0/4.0) + pow(a, 5.0)*4.0/3.0*pow(cPos - a, 3.0/4.0))

        //2: рещение СЛАУ и нахождение коэфициентов a_i.
        val matrix = arrayOf<DoubleArray>(moments.copyOfRange(0, 3), moments.copyOfRange(1, 4), moments.copyOfRange(2, 5))
        val bs = arrayOf<DoubleArray>(doubleArrayOf(-1*moments[3]), doubleArrayOf(-1*moments[4]), doubleArrayOf(-1*moments[5]))
        val aCoef = SLAEAccurateMethods.GaussMethod(matrix, bs)

        //нахождение узлов x_i как корней узлового многочлена (по формуле Кордано)
        val p: Double = (aCoef[1][0] - aCoef[2][0]*aCoef[2][0]/3)
        val q: Double = 2*pow(aCoef[2][0], 3.0)/27 - aCoef[2][0]*aCoef[1][0]/3 + aCoef[0][0]
        var delta: Double = pow(q/2, 2.0) + pow(p/3, 3.0)

        var phi: Double
        if(q < 0) phi = atan(sqrt(-1*delta)/(-1*q/2))
        else if(q > 0) phi = atan(sqrt(-1*delta)/(-1*q/2)) + PI
        else phi = PI/2

        val x = mutableListOf<Double>(2*sqrt(-1*p/3)*cos(phi/3) - aCoef[2][0]/3, 2*sqrt(-1*p/3)*cos(phi/3+ PI*2/3) - aCoef[2][0]/3, 2*sqrt(-1*p/3)*cos(phi/3+ PI*4/3) - aCoef[2][0]/3)
        //Знаем, что корня точно 3 различных или с вещественной парой, нашли по Кардано. Теперь находим A_i решением слау и уповаем,что не выйдет ошибок

        val fMatrix = arrayOf<DoubleArray>(doubleArrayOf(1.0, 1.0, 1.0), x.toDoubleArray(), doubleArrayOf(x[0]*x[0], x[1]*x[1], x[2]*x[2]))
        val fb = arrayOf<DoubleArray>(doubleArrayOf(moments[0]), doubleArrayOf(moments[1]), doubleArrayOf(moments[2]))
        val A = SLAEAccurateMethods.GaussMethod(fMatrix, fb)

        s += f(x[0])*A[0][0] + f(x[1])*A[1][0] + f(x[2])*A[2][0]

        return s
    }
    fun newtonCots(f: (Double) -> Double, a: Double, b: Double, h: Double): Double {

        var s = 0.0
        var cPos = a

        while(cPos + h <b) {

            val moments = DoubleArray(3) { 0.0 }
            moments[0] = 4.0/3.0*pow(cPos + h - a, 3.0/4.0) - 4.0/3.0*pow(cPos - a, 3.0/4.0)
            moments[1] = 4.0/7.0*pow(cPos + h - a, 7.0/4.0) + a*4.0/3.0*pow(cPos + h - a, 3.0/4.0) - (4.0/7.0*pow(cPos - a, 7.0/4.0) + a*4.0/3.0*pow(cPos - a, 3.0/4.0))
            moments[2] = 4.0/11.0*pow(cPos + h - a, 11.0/4.0) + 2*a*4.0/7.0*pow(cPos + h - a, 7.0/4.0) + pow(a, 2.0)*4.0/3.0*pow(cPos + h - a, 3.0/4.0) - (4.0/11.0*pow(cPos - a, 11.0/4.0) + 2*a*4.0/7.0*pow(cPos - a, 7.0/4.0) + pow(a, 2.0)*4.0/3.0*pow(cPos - a, 3.0/4.0))

            val x = mutableListOf<Double>(cPos, cPos + h/2, cPos + h)
            val fMatrix = arrayOf<DoubleArray>(doubleArrayOf(1.0, 1.0, 1.0), x.toDoubleArray(), doubleArrayOf(x[0]*x[0], x[1]*x[1], x[2]*x[2]))
            val fb = arrayOf<DoubleArray>(doubleArrayOf(moments[0]), doubleArrayOf(moments[1]), doubleArrayOf(moments[2]))
            val A = SLAEAccurateMethods.GaussMethod(fMatrix, fb)

            s += f(x[0])*A[0][0] + f(x[1])*A[1][0] + f(x[2])*A[2][0]

            cPos += h
        }

        //h = b - cPos
        val moments = DoubleArray(3) { 0.0 }
        moments[0] = 4.0/3.0*pow(b - a, 3.0/4.0) - 4.0/3.0*pow(cPos - a, 3.0/4.0)
        moments[1] = 4.0/7.0*pow(b - a, 7.0/4.0) + a*4.0/3.0*pow(b - a, 3.0/4.0) - (4.0/7.0*pow(cPos - a, 7.0/4.0) + a*4.0/3.0*pow(cPos - a, 3.0/4.0))
        moments[2] = 4.0/11.0*pow(b - a, 11.0/4.0) + 2*a*4.0/7.0*pow(b - a, 7.0/4.0) + pow(a, 2.0)*4.0/3.0*pow(b - a, 3.0/4.0) - (4.0/11.0*pow(cPos - a, 11.0/4.0) + 2*a*4.0/7.0*pow(cPos - a, 7.0/4.0) + pow(a, 2.0)*4.0/3.0*pow(cPos - a, 3.0/4.0))

        val x = mutableListOf<Double>(cPos, cPos + h/2, cPos + h)
        val fMatrix = arrayOf<DoubleArray>(doubleArrayOf(1.0, 1.0, 1.0), x.toDoubleArray(), doubleArrayOf(x[0]*x[0], x[1]*x[1], x[2]*x[2]))
        val fb = arrayOf<DoubleArray>(doubleArrayOf(moments[0]), doubleArrayOf(moments[1]), doubleArrayOf(moments[2]))
        val A = SLAEAccurateMethods.GaussMethod(fMatrix, fb)

        s += f(x[0])*A[0][0] + f(x[1])*A[1][0] + f(x[2])*A[2][0]


        return s
    }
}