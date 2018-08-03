
import java.io.*;
import java.util.*;

class Main {

	public static void main(String[] args) throws IOException {
		InputReader scan = new InputReader(System.in);
		StringBuilder result = new StringBuilder();

		String before = scan.next();
		String after = scan.next();
		if (after.equals(before)) {
			System.out.println("No");
			return;
		}
		while (after.length() > before.length()) {
			if (after.charAt(0) == 'A') {
				after = after.substring(1);
			} else {
				after = after.substring(1);
				after = new StringBuilder(after).reverse().toString();
			}
		}
//		boolean reversed = false;
//		while (after.length()>before.length()) {
//			if (after.charAt((reversed)?after.length()-1:0) == 'A') {
//				after = (reversed)?after.substring(0, after.length()-1):after.substring(1);
//			} else {
//				after = (reversed)?after.substring(0,after.length()-1):after.substring(1);
//				reversed = !reversed;
//			}			
//		}
		result.append((after.equals(before)) ? "Yes" : "No");

		System.out.println(result);
	}

	static class InputReader {

		StringTokenizer tokenizer;
		BufferedReader reader;
		String token;
		String temp;

		public InputReader(InputStream stream) {
			tokenizer = null;
			reader = new BufferedReader(new InputStreamReader(stream));
		}

		public InputReader(FileInputStream stream) {
			tokenizer = null;
			reader = new BufferedReader(new InputStreamReader(stream));
		}

		public String nextLine() throws IOException {
			return reader.readLine();
		}

		public String next() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					if (temp != null) {
						tokenizer = new StringTokenizer(temp);
						temp = null;
					} else {
						tokenizer = new StringTokenizer(reader.readLine());
					}

				} catch (IOException e) {
				}
			}
			return tokenizer.nextToken();
		}

		public double nextDouble() {
			return Double.parseDouble(next());
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}

		public long nextLong() {
			return Long.parseLong(next());
		}

		public int[] nextIntArray(int n) {
			int[] res = new int[n];
			for (int i = 0; i < n; i++) {
				res[i] = Integer.parseInt(next());
			}
			return res;
		}

		public int[][] nextIntMatrix(int n, int m) {
			int[][] res = new int[n][m];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					res[i][j] = Integer.parseInt(next());
				}
			}
			return res;
		}
	}

//	static class InputReader {
//
//		InputStream is = System.in;
//		byte[] inbuf = new byte[1 << 23];
//		int lenbuf = 0, ptrbuf = 0;
//
//		public InputReader() throws IOException {
//			lenbuf = is.read(inbuf);
//		}
//
//		public int readByte() {
//
//			if (ptrbuf >= lenbuf) {
//				return -1;
//			}
//
//			return inbuf[ptrbuf++];
//		}
//
//		public boolean hasNext() {
//			int t = skip();
//
//			if (t == -1) {
//				return false;
//			}
//			ptrbuf--;
//			return true;
//		}
//
//		public boolean isSpaceChar(int c) {
//			return !(c >= 33 && c <= 126);
//		}
//
//		public int skip() {
//			int b;
//			while ((b = readByte()) != -1 && isSpaceChar(b))
//				;
//			return b;
//		}
//
//		public double nextDouble() {
//			return Double.parseDouble(next());
//		}
//
//		public char nextChar() {
//			return (char) skip();
//		}
//
//		public String next() {
//			int b = skip();
//			StringBuilder sb = new StringBuilder();
//			while (!(isSpaceChar(b))) {
//				sb.appendCodePoint(b);
//				b = readByte();
//			}
//			return sb.toString();
//		}
//
//		public char[] ns(int n) {
//			char[] buf = new char[n];
//			int b = skip(), p = 0;
//			while (p < n && !(isSpaceChar(b))) {
//				buf[p++] = (char) b;
//				b = readByte();
//			}
//			return n == p ? buf : Arrays.copyOf(buf, p);
//		}
//
//		public char[][] nm(int n, int m) {
//			char[][] map = new char[n][];
//			for (int i = 0; i < n; i++) {
//				map[i] = ns(m);
//			}
//			return map;
//		}
//
//		public int[] na(int n) {
//			int[] a = new int[n];
//			for (int i = 0; i < n; i++) {
//				a[i] = nextInt();
//			}
//			return a;
//		}
//
//		public int nextInt() {
//			int num = 0, b;
//			boolean minus = false;
//			while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
//				;
//			if (b == '-') {
//				minus = true;
//				b = readByte();
//			}
//
//			while (true) {
//				if (b >= '0' && b <= '9') {
//					num = num * 10 + (b - '0');
//				} else {
//					return minus ? -num : num;
//				}
//				b = readByte();
//			}
//		}
//
//		public long nextLong() {
//			long num = 0;
//			int b;
//			boolean minus = false;
//			while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
//				;
//			if (b == '-') {
//				minus = true;
//				b = readByte();
//			}
//
//			while (true) {
//				if (b >= '0' && b <= '9') {
//					num = num * 10 + (b - '0');
//				} else {
//					return minus ? -num : num;
//				}
//				b = readByte();
//			}
//		}
//
//		public int[] nextIntArray(int n) {
//			int[] res = new int[n];
//			for (int i = 0; i < n; i++) {
//				res[i] = Integer.parseInt(next());
//			}
//			return res;
//		}
//
//		public int[][] nextIntMatrix(int n, int m) {
//			int[][] res = new int[n][m];
//			for (int i = 0; i < n; i++) {
//				for (int j = 0; j < m; j++) {
//					res[i][j] = Integer.parseInt(next());
//				}
//			}
//			return res;
//		}
//
//	}
}
